package br.com.alura.agenda.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.TelefoneDAO;
import br.com.alura.agenda.database.AgendaDatabase;
import br.com.alura.agenda.model.Aluno;
import br.com.alura.agenda.model.Telefone;

public class ListaAlunosAdapter extends BaseAdapter {
    private final List<Aluno> alunos = new ArrayList<>();
    private final Context context;
    private final TelefoneDAO dao;

    public ListaAlunosAdapter(Context context) {
        this.context = context;
        dao = AgendaDatabase.getInstance(context).getTelefoneDAO();
    }

    //quantidade de elementos que o adapter terá
    @Override
    public int getCount() {
        return alunos.size();
    }

    //o item que queremos capturar baseado na posição
    @Override
    public Aluno getItem(int position) {
        return alunos.get(position);
    }

    // devolve o id do conjunto
    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    // apresenta a view para cada elemento do adapter
    // é aqui que criamos a view
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        @SuppressLint("ViewHolder") View viewCriada = criaView(viewGroup);

        Aluno alunoDevolvido = alunos.get(position);
        vincula(viewCriada, alunoDevolvido);
        return viewCriada;
    }

    @SuppressLint("SetTextI18n")
    private void vincula(View view, Aluno aluno) {
        TextView nome = view.findViewById(R.id.item_aluno_nome);
        nome.setText(aluno.getNome());
        TextView telefone = view.findViewById(R.id.item_aluno_telefone);
        final Telefone primeiroTelefone = dao.buscaPrimeiroTelefoneDoAluno(aluno.getId());
        telefone.setText(primeiroTelefone.getNumero());
    }

    private View criaView(ViewGroup viewGroup) {
        return LayoutInflater
                .from(context)
                .inflate(R.layout.item_aluno, viewGroup, false);
    }


    public void atualiza(List<Aluno> alunos) {
        this.alunos.clear();
        this.alunos.addAll(alunos);
        notifyDataSetChanged();
    }

    public void remove(Aluno aluno) {
        this.alunos.remove(aluno);
        notifyDataSetChanged();
    }
}
