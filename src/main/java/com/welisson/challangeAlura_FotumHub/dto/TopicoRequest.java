package com.welisson.challangeAlura_FotumHub.dto;

import lombok.Data;

@Data
public class TopicoRequest {
    private String titulo;
    private String mensagem;
    private String status;
    private String autor;
    private String curso;
}
