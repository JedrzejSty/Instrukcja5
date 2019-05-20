package com.example.instrukcja4;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.media.VolumeProviderCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.instrukcja4.tasks.TaskListContent;


/**
 * A simple {@link Fragment} subclass.
 */
public class TaskInfoFragment extends Fragment {


    public TaskInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_info, container, false);
    }


    public void displayTask(TaskListContent.Task task) {
        FragmentActivity activity = getActivity();

        TextView taskInfoTitle = activity.findViewById(R.id.taskInfoTitle);
        TextView taskInfoDescription = activity.findViewById(R.id.taskInfoDescription);
        TextView taskInfoDate = activity.findViewById(R.id.taskDate);
        ImageView taskInfoImage = activity.findViewById(R.id.taskInfoImage);

        taskInfoTitle.setText(task.title);
        taskInfoDescription.setText(task.author);
        taskInfoDate.setText(task.date);


        if (task.picPath != null && !task.picPath.isEmpty()) {

            if (task.picPath.contains("drawable")) {
                Drawable taskDrawable;
                switch (task.picPath) {
                    case "drawable 1":
                        taskDrawable = activity.getResources().getDrawable(R.drawable.img_0);
                        break;
                    case "drawable 2":
                        taskDrawable = activity.getResources().getDrawable(R.drawable.img_1);
                        break;
                    case "drawable 3":
                        taskDrawable = activity.getResources().getDrawable(R.drawable.img_2);
                        break;
                    default:
                        taskDrawable = activity.getResources().getDrawable(R.drawable.img_3);
                }
                taskInfoImage.setImageDrawable(taskDrawable);
            }

        }else {
            taskInfoImage.setImageDrawable(activity.getResources().getDrawable(R.drawable.img_0));

        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        FragmentActivity activity = getActivity();
        super.onActivityCreated(savedInstanceState);
        Intent intent = getActivity().getIntent();
        if(intent != null){
            TaskListContent.Task receivedTask = intent.getParcelableExtra(MainActivity.taskExtra);
            if (receivedTask != null){
                displayTask(receivedTask);
            }
        }

    }


}