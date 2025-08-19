package com.welisson.challangeAlura_FotumHub.controller;

import com.welisson.challangeAlura_FotumHub.dto.TopicoRequest;
import com.welisson.challangeAlura_FotumHub.dto.TopicoResponse;
import com.welisson.challangeAlura_FotumHub.entity.Topico;
import com.welisson.challangeAlura_FotumHub.repository.TopicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor
public class TopicoController {

    private final TopicoRepository topicoRepository;

    //listar todos os topicos
    @GetMapping
    public List<TopicoResponse> listar() {
        return topicoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }


    //Buscar topico por id
    @GetMapping("/{id}")
    public TopicoResponse buscarPorId(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
        return toResponse(topico);
    }

    //criar topico
    @PostMapping
    public TopicoResponse criar(@RequestBody TopicoRequest dto) {
        Topico topico = new Topico();
        topico.setTitulo(dto.getTitulo());
        topico.setMensagem(dto.getMensagem());
        topico.setStatus(dto.getStatus());
        topico.setAutor(dto.getAutor());
        topico.setCurso(dto.getCurso());

        Topico salvo = topicoRepository.save(topico);
        return toResponse(salvo);
    }

    //Atualizar topico
    @PutMapping("/{id}")
    public TopicoResponse atualiza(@PathVariable Long id, @RequestBody TopicoRequest dto) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));

        topico.setTitulo(dto.getTitulo());
        topico.setMensagem(dto.getMensagem());
        topico.setStatus(dto.getStatus());
        topico.setAutor(dto.getAutor());
        topico.setCurso(dto.getCurso());

        Topico atualizado = topicoRepository.save(topico);
        return toResponse(atualizado);
    }

    // Deletar um tópico
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        topicoRepository.deleteById(id);
    }

    //auxiliar na conversao
    private TopicoResponse toResponse(Topico topico) {
        return TopicoResponse.builder()
                .id(topico.getId())
                .titulo(topico.getTitulo())
                .mensagem(topico.getMensagem())
                .dataCriacao(topico.getDataCriacao())
                .status(topico.getStatus())
                .autor(topico.getAutor())
                .curso(topico.getCurso())
                .build();
    }

}
