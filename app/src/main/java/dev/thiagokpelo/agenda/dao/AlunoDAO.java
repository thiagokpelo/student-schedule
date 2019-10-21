package dev.thiagokpelo.agenda.dao;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import dev.thiagokpelo.agenda.model.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;

    private void atualizaIds() {
        contadorDeIds++;
    }

    public void salva(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        atualizaIds();
    }

    public void edita(Aluno aluno) {
        Aluno alunoEncontrado = buscaAlunoPeloId(aluno);

        if (alunoEncontrado != null) {
            int posicaoDoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoDoAluno, aluno);
        }
    }

    public void remove(Aluno aluno) {
        Aluno alunoEncontrado = buscaAlunoPeloId(aluno);

        if (alunoEncontrado != null) {
            alunos.remove(alunoEncontrado);
        }
    }

    @Nullable
    private Aluno buscaAlunoPeloId(Aluno aluno) {

        for (Aluno a : alunos) {
            if (a.getId() == aluno.getId()) {
                return a;
            }
        }
        return null;
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
