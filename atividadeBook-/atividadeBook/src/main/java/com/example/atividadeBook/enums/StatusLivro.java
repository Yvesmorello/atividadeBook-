package com.example.atividadeBook.enums;

public enum StatusLivro {
    DISPONIVEL(0),
    EM_EMPRESTIMO(1),
    RESERVADO(2);

    private Integer status;

    StatusLivro(Integer status) {
        this.status = status;
    };
}
