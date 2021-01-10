package br.com.alura.agenda;

import android.app.Application;

import br.com.alura.agenda.dao.AlunoDao;
import br.com.alura.agenda.model.Aluno;

public class AgendaApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AlunoDao dao = new AlunoDao();
        dao.salva(new Aluno("Gabriel", "(11) 4184-3927", "gabriel.darlan@hotmail.com"));
        dao.salva(new Aluno("Maria", "(11) 4184-3927", "maria.joaquinan@hotmail.com"));
    }
}
