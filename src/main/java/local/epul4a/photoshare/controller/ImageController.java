package local.epul4a.photoshare.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import local.epul4a.photoshare.model.ImageInfo;
import local.epul4a.photoshare.service.FilesStorageService;

@Controller
public class ImageController {

  @Autowired
  FilesStorageService storageService;

  @GetMapping("/")
  public String homepage() {
    return "redirect:/images";
  }

  @GetMapping("/images/new")
  public String newImage(Model model) {
    return "upload_form";
  }

  @PostMapping("/images/upload")
  public String uploadImage(Model model, @RequestParam("file") MultipartFile file) {
    String message = "";

    try {
      storageService.save(file);

      message = "L'image a été téléchargée avec succès : " + file.getOriginalFilename();
      model.addAttribute("message", message);
    } catch (Exception e) {
      message = "Impossible de télécharger l'image : " + file.getOriginalFilename() + ". Erreur : " + e.getMessage();
      model.addAttribute("message", message);
    }

    return "upload_form";
  }

  @GetMapping("/images")
  public String getListImages(Model model) {
    List<ImageInfo> imageInfos = storageService.loadAll().map(path -> {
      String filename = path.getFileName().toString();
      String url = MvcUriComponentsBuilder
          .fromMethodName(ImageController.class, "getImage", path.getFileName().toString()).build().toString();

      return new ImageInfo(filename, url);
    }).collect(Collectors.toList());

    model.addAttribute("images", imageInfos);

    return "images";
  }

  @GetMapping("/images/{filename:.+}")
  public ResponseEntity<Resource> getImage(@PathVariable String filename) {
    Resource file = storageService.load(filename);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
  }

  @GetMapping("/images/delete/{filename:.+}")
  public String deleteImage(@PathVariable String filename, Model model, RedirectAttributes redirectAttributes) {
    try {
      boolean existed = storageService.delete(filename);

      if (existed) {
        redirectAttributes.addFlashAttribute("message", "Suppression de l'image réussie : " + filename);
      } else {
        redirectAttributes.addFlashAttribute("message", "L'image n'existe pas !");
      }
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message",
          "Impossible de supprimer l'image : " + filename + ". Erreur : " + e.getMessage());
    }

    return "redirect:/images";
  }
}