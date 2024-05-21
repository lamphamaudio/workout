package com.tlu.btlandroid.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tlu.btlandroid.R;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import adapter.Dayadapter;
import untity.day;

@RequiresApi(api = Build.VERSION_CODES.O)
public class workoutFragment extends Fragment {

    private View mView;
    TextView tv4;

    private RecyclerView rcv;
    private Dayadapter dayadapter;

    LocalDate localDate= LocalDate.now();
    Calendar calendar = Calendar.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.workoutfragment,container,false);

        rcv = mView.findViewById(R.id.rc1);
        dayadapter = new Dayadapter(getContext(),getListDay());
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(mView.getContext(),RecyclerView.HORIZONTAL,false);
        rcv.setLayoutManager(linearLayoutManager);


        String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String dayName = dayNames[calendar.get(Calendar.DAY_OF_WEEK) - 1];
        dayadapter.setData(getListDay());
        rcv.setAdapter(dayadapter);
        tv4 = mView.findViewById(R.id.tv4);
        tv4.setText(dayName.toString());
        return mView;
    }

//    private List<day> getListDay() {
//        List<day>list = new ArrayList<>();
//        list.add(new day(R.drawable.thu2,"Monday"));
//        list.add(new day(R.drawable.thu3,"Tuesday"));
//        list.add(new day(R.drawable.thu4,"Wednesday"));
//        list.add(new day(R.drawable.thu5,"Thursday"));
//        list.add(new day(R.drawable.thu6,"Friday"));
//        list.add(new day(R.drawable.thu7,"Saturday"));
//        list.add(new day(R.drawable.chunhat,"Sunday"));
//        return list;
//    }
            private List<day> getListDay() {
                List<day> list = new ArrayList<>();

                // Get current day of week (1 to 7, where 1=Sunday, 2=Monday, ..., 7=Saturday)
                int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

                // Add today's day
                list.add(new day(getDayImageResource(currentDayOfWeek), getDayName(currentDayOfWeek)));

                // Calculate tomorrow's day
                int tomorrowDayOfWeek = currentDayOfWeek + 1 > 7 ? 1 : currentDayOfWeek + 1;
                list.add(new day(getDayImageResource(tomorrowDayOfWeek), getDayName(tomorrowDayOfWeek)));

                return list;
            }
    private int getDayImageResource(int dayOfWeek) {
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                return R.drawable.chunhat;
            case Calendar.MONDAY:
                return R.drawable.thu2;
            case Calendar.TUESDAY:
                return R.drawable.thu3;
            case Calendar.WEDNESDAY:
                return R.drawable.thu4;
            case Calendar.THURSDAY:
                return R.drawable.thu5;
            case Calendar.FRIDAY:
                return R.drawable.thu6;
            case Calendar.SATURDAY:
                return R.drawable.thu7;
            default:
                return R.drawable.chunhat;
        }
    }

    private String getDayName(int dayOfWeek) {
        String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return dayNames[dayOfWeek - 1];
    }
}
