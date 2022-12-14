package com.github.nogueiralegacy.jogoDaVelha.domain;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JogoTest {
    @Test
    public void jogadorXComeca() {
        Jogo jogo = new Jogo();
        jogo.jogada(0, 0);

        assertEquals("X", jogo.getTabuleiro().getCasas()[0][0]);
    }

    @Test
    public void jogadasIntercaladasEntreJogadores() {
        Jogo jogo = new Jogo();

        // Jogador X
        jogo.jogada(0, 0);
        // Jogador O
        jogo.jogada(0, 1);
        // Jogador X
        jogo.jogada(1, 0);
        // Jogador O
        jogo.jogada(1, 1);

        Tabuleiro tabuleiroEsperado = new Tabuleiro();
        tabuleiroEsperado.getCasas()[0][0] = "X";
        tabuleiroEsperado.getCasas()[0][1] = "O";
        tabuleiroEsperado.getCasas()[1][0] = "X";
        tabuleiroEsperado.getCasas()[1][1] = "O";

        assertArrayEquals(tabuleiroEsperado.getCasas(), jogo.getTabuleiro().getCasas());
    }

    @Test
    public void contaJogadas() {
        Jogo jogo = new Jogo();

        jogo.jogada(0, 0);
        jogo.jogada(0, 1);
        jogo.jogada(1, 0);
        jogo.jogada(1, 1);

        assertEquals(4, jogo.getCountJogadas());
    }

    @Test
    public void reiniciaJogo() {
        Jogo jogo = new Jogo();
        jogo.jogada(0, 0);
        jogo.jogada(0, 1);
        jogo.jogada(1, 0);
        jogo.jogada(1, 1);

        jogo.reiniciaJogo();

        assertTrue(jogo.getCountJogadas() == 0);
    }

    @Test
    public void jogadorXGanha() {
        Jogo jogo = new Jogo();
        Jogador jogadorX = new Jogador("X");
        // Jogador X
        jogo.jogada(0, 0);
        // Jogador O
        jogo.jogada(0, 1);
        // Jogador X
        jogo.jogada(1, 0);
        // Jogador O
        jogo.jogada(1, 1);
        // Jogador X
        jogo.jogada(2, 0);

        assertTrue(jogo.validaVitoria(jogadorX.getIdentificador()));
    }

    @Test
    public void jogadorOGanha() {
        Jogo jogo = new Jogo();
        Jogador jogadorO = new Jogador("O");

        // Jogador X
        jogo.jogada(0, 0);
        // Jogador O
        jogo.jogada(0, 1);
        // Jogador X
        jogo.jogada(1, 0);
        // Jogador O
        jogo.jogada(1, 1);
        // Jogador X
        jogo.jogada(0, 2);
        // Jogador O
        jogo.jogada(2, 1);

        assertTrue(jogo.validaVitoria(jogadorO.getIdentificador()));
    }

    @Test
    public void empate() {
        Jogo jogo = new Jogo();

        // Jogador X
        jogo.jogada(0, 0);
        // Jogador O
        jogo.jogada(0, 1);
        // Jogador X
        jogo.jogada(0, 2);
        // Jogador O
        jogo.jogada(1, 0);
        // Jogador X
        jogo.jogada(1, 1);
        // Jogador O
        jogo.jogada(1, 2);
        // Jogador X
        jogo.jogada(2, 0);
        // Jogador O
        jogo.jogada(2, 1);
        // Jogador X
        jogo.jogada(2, 2);

        assertTrue(jogo.verificaEmpate());
    }
}
