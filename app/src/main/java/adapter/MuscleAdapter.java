package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tlu.btlandroid.R;

import java.util.List;

import untity.Muscle;

public class MuscleAdapter extends RecyclerView.Adapter<MuscleAdapter.muscleViewHolder>{
    private List<Muscle> mListMuscle;

    public MuscleAdapter(List<Muscle> mListMuscle) {
        this.mListMuscle = mListMuscle;
    }
    @NonNull
    @Override
    public muscleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_muscle,parent,false);
        return new muscleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull muscleViewHolder holder, int position) {
        Muscle muscle = mListMuscle.get(position);
        if (muscle==null){
            return;
        }
        holder.nameMuscle.setText(muscle.getName());
        holder.number1.setText(muscle.getNumber1());
        holder.number2.setText(muscle.getNumber2());
    }

    @Override
    public int getItemCount() {
        if (mListMuscle!=null){
            return mListMuscle.size();
        }
        return 0;
    }

    public class muscleViewHolder extends RecyclerView.ViewHolder{
        private TextView nameMuscle;
        private TextView number1;
        private TextView number2;


        public muscleViewHolder(@NonNull View itemView) {
            super(itemView);
            nameMuscle = itemView.findViewById(R.id.muslce_name);
            number1 = itemView.findViewById(R.id.muslce_number1);
            number2 = itemView.findViewById(R.id.muslce_number2);

        }
    }
}
