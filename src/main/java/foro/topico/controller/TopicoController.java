package foro.topico.controller;

import foro.topico.Topico;
import foro.topico.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<Topico> getAllTopicos() {
        return topicoService.getAllTopicos();
    }

    @PostMapping
    public Topico createTopico(@RequestBody Topico topico) {
        return topicoService.saveTopico(topico);
    }

    @PutMapping("/{id}")
    public Topico updateTopico(@PathVariable Long id, @RequestBody Topico topico) {
        return topicoService.updateTopico(id, topico);
    }

    @DeleteMapping("/{id}")
    public void deleteTopico(@PathVariable Long id) {
        topicoService.deleteTopico(id);
    }
}