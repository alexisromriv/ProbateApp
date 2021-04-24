package app2you.probateapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
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



            tvPregunta.setTextColor(pregunta.getRespuestaSeleccionada().isCorrecta() ? Color.parseColor("#198754") :Color.parseColor("#dc3545"));

            for (int i = 0; i < 3 ; i++) {
                tvRespuestas.get(i).setText(respuestas.get(i).getTitulo());
                tvRespuestas.get(i).setAlpha(.5f);
                tvRespuestas.get(i).setTextSize(16);
                tvRespuestas.get(i).setTextColor(Color.BLACK);
                if (pregunta.getPregunta().getRespuestas().get(i).isCorrecta()) {
                    tvRespuestas.get(i).setTextColor(Color.parseColor("#198754"));

                }
            }

            int selectionIndex = pregunta.getPregunta().getRespuestas().indexOf(pregunta.getRespuestaSeleccionada());
            tvRespuestas.get(selectionIndex).setAlpha(1);
            tvRespuestas.get(selectionIndex).setTextSize(24);
            if (!pregunta.getRespuestaSeleccionada().isCorrecta()) {
                tvRespuestas.get(selectionIndex).setTextColor(Color.parseColor("#dc3545"));
            }



        }
    }

}
