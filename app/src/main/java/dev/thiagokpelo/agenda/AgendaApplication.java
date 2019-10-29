package dev.thiagokpelo.agenda;

import android.app.Application;

import dev.thiagokpelo.agenda.dao.AlunoDAO;
import dev.thiagokpelo.agenda.model.Aluno;

class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Thiago", "11222333", "thiago@kpelo.com.br"));
        dao.salva(new Aluno("Tate", "11222333", "tate@kpelo.com.br"));
    }
}