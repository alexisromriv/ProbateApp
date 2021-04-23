package app2you.probateapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app2you.probateapp.entidades.PreguntaConRespuesta;
import app2you.probateapp.entidades.Respuesta;

public class ResultadoExamenAdapter extends RecyclerView.Adapter<ResultadoExamenAdapter.ViewHolderResultadoExamen> {
    List<PreguntaConRespuesta> preguntas;

    public ResultadoExamenAdapter(List<PreguntaConRespuesta> preguntas) {
        this.preguntas = preguntas;
    }

    @NonNull
    @Override
    public ViewHolderResultadoExamen onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.correccion_item, null, false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolderResultadoExamen(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderResultadoExamen holder, int position) {
        holder.asignarDatos(preguntas.get(position));
    }

    @Override
    public int getItemCount() {
        return preguntas.size();
    }

    public class ViewHolderResultadoExamen extends RecyclerView.ViewHolder {
        TextView tvPregunta;
        List<TextView> tvRespuestas = new ArrayList<>();
        TextView tvRespuesta1;
        TextView tvRespuesta2;
        TextView tvRespuesta3;


        public ViewHolderResultadoExamen(@NonNull View itemView) {
            super(itemView);
            tvPregunta = itemView.findViewById(R.id.tvPreguntaItem);
            tvRespuesta1 = itemView.findViewById(R.id.tvRespuestaItem1);
            tvRespuesta2 = itemView.findViewById(R.id.tvRespuestaItem2);
            tvRespuesta3 = itemView.findViewById(R.id.tvRespuestaItem3);
            tvRespuestas.add(tvRespuesta1);
            tvRespuestas.add(tvRespuesta2);
            tvRespuestas.add(tvRespuesta3);
        }

        public void asignarDatos(PreguntaConRespuesta pregunta) {
            tvPregunta.setText(pregunta.getPregunta().getTitulo());

            List<Respuesta> respuestas = pregunta.getPregunta().getRespuestas();
            tvRespuesta1.setText(respuestas.get(0).getTitulo());
            tvRespuesta2.setText(respuestas.get(1).getTitulo());
            tvRespuesta3.setText(respuestas.get(2).getTitulo());

            int selectionIndex = pregunta.getPregunta().getRespuestas().indexOf(pregunta.getRespuestaSeleccionada());
            tvRespuestas.get(selectionIndex).setAlpha(1);
            tvRespuestas.get(selectionIndex).setTextSize(18);
            tvPregunta.setTextColor(pregunta.getRespuestaSeleccionada().isCorrecta() ? Color.GREEN : Color.RED);

            if (pregunta.getPregunta().getRespuestas().get(0).isCorrecta()) {
                tvRespuestas.get(0).setTextColor(Color.GREEN);
            }
            if (pregunta.getPregunta().getRespuestas().get(1).isCorrecta()) {
                tvRespuestas.get(1).setTextColor(Color.GREEN);
            }
            if (pregunta.getPregunta().getRespuestas().get(2).isCorrecta()) {
                tvRespuestas.get(2).setTextColor(Color.GREEN);
            }

            if (!pregunta.getRespuestaSeleccionada().isCorrecta()) {
                tvRespuestas.get(selectionIndex).setTextColor(Color.RED);
            }



        }
    }

}
