package app2you.probateapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app2you.probateapp.entidades.Tema;

public class TemasAdapter extends RecyclerView.Adapter<TemasAdapter.ViewHolderTemas> {
    List<Tema> temas;

    public TemasAdapter(List<Tema> temas) {
        this.temas = temas;
    }

    @NonNull
    @Override
    public ViewHolderTemas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tema_item, null, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        return new ViewHolderTemas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTemas holder, int position) {
        holder.asignarDatos(temas.get(position));
    }

    @Override
    public int getItemCount() {
        return temas.size();
    }

    public class ViewHolderTemas extends RecyclerView.ViewHolder {
        TextView tvTema;
        public ViewHolderTemas(@NonNull View itemView) {
            super(itemView);
            tvTema = itemView.findViewById(R.id.tvTemaItem);
        }

        public void asignarDatos(Tema tema) {
            tvTema.setText(tema.getNombre());
        }
    }
}
