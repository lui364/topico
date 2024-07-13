package foro.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    public List<Topico> getAllTopicos() {
        return topicoRepository.findAll();
    }

    public Topico saveTopico(Topico topico) {
        topico.setFechaCreacion(LocalDateTime.now());
        return topicoRepository.save(topico);
    }

    public Topico updateTopico(Long id, Topico topicoDetails) {
        Topico topico = topicoRepository.findById(id).orElseThrow();
        topico.setMensaje(topicoDetails.getMensaje());
        topico.setNombreCurso(topicoDetails.getNombreCurso());
        topico.setTitulo(topicoDetails.getTitulo());
        return topicoRepository.save(topico);
    }

    public void deleteTopico(Long id) {
        topicoRepository.deleteById(id);
    }
}