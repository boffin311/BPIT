package com.example.himanshu.bpit.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.aigestudio.wheelpicker.WheelPicker;
import com.example.himanshu.bpit.Activities.MainActivity;
import com.example.himanshu.bpit.R;

import java.util.ArrayList;

public class FragmentOtherInfo extends Fragment {
    public FragmentOtherInfo(){}
TextView tvYear,tvStream,tvSection,tvCourse;
Button btnLetsGo;

   WheelPicker wheelPickerYear;
   View dialogueView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_other_info,container,false);
        tvYear=view.findViewById(R.id.tvYear);
        tvSection=view.findViewById(R.id.tvSection);
        tvStream=view.findViewById(R.id.tvStream);
        tvCourse=view.findViewById(R.id.tvCourse);
        btnLetsGo=view.findViewById(R.id.btnLetsGo);
        tvYear.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dialogueView=getLayoutInflater().inflate(R.layout.dialogue_pick_year,null);
               wheelPickerYear=dialogueView.findViewById(R.id.whellPickerYear);
               AlertDialog.Builder dialog=new AlertDialog.Builder(getContext());
                ArrayList<String> year=new ArrayList<>();
                year.add("1st");year.add("2nd");year.add("3rd");year.add("4th");
                wheelPickerYear.setData(year);
              dialog.setTitle("Choose Year");
              dialog.setView(dialogueView);

              dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      tvYear.setText(wheelPickerYear.getData().get(wheelPickerYear.getCurrentItemPosition()).toString());
                  }
              });
               dialog.show();

           }
       });

        tvStream.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        dialogueView=getLayoutInflater().inflate(R.layout.dialogue_pick_year,null);
        wheelPickerYear=dialogueView.findViewById(R.id.whellPickerYear);
        AlertDialog.Builder dialog=new AlertDialog.Builder(getContext());
        ArrayList<String> year=new ArrayList<>();
        year.add("CSE");year.add("EEE");year.add("IT");year.add("ECE");
        wheelPickerYear.setData(year);
        dialog.setTitle("Choose Stream");
        dialog.setView(dialogueView);

        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvStream.setText(wheelPickerYear.getData().get(wheelPickerYear.getCurrentItemPosition()).toString());
            }
        });
        dialog.show();

     }
});
        tvSection.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           dialogueView=getLayoutInflater().inflate(R.layout.dialogue_pick_year,null);
           wheelPickerYear=dialogueView.findViewById(R.id.whellPickerYear);
           AlertDialog.Builder dialog=new AlertDialog.Builder(getContext());
           ArrayList<String> year=new ArrayList<>();
           year.add("A");year.add("B");
           wheelPickerYear.setData(year);
           wheelPickerYear.setVisibleItemCount(2);
           dialog.setTitle("Choose Section");
           dialog.setView(dialogueView);

           dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                   tvSection.setText(wheelPickerYear.getData().get(wheelPickerYear.getCurrentItemPosition()).toString());
               }
           });
           dialog.show();

       }
   });
   tvCourse.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           dialogueView=getLayoutInflater().inflate(R.layout.dialogue_pick_year,null);
           wheelPickerYear=dialogueView.findViewById(R.id.whellPickerYear);
           AlertDialog.Builder dialog=new AlertDialog.Builder(getContext());
           ArrayList<String> year=new ArrayList<>();
           year.add("BTech");year.add("BBA");year.add("MBA");
           wheelPickerYear.setData(year);
           wheelPickerYear.setVisibleItemCount(2);
           dialog.setTitle("Choose Section");
           dialog.setView(dialogueView);

           dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                   tvCourse.setText(wheelPickerYear.getData().get(wheelPickerYear.getCurrentItemPosition()).toString());
               }
           });
           dialog.show();
       }
   });
   btnLetsGo.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent intent=new Intent(getActivity(), MainActivity.class);
           intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
           getActivity().getBaseContext().startActivity(intent);
       }
   });
        return view;
    }
}
