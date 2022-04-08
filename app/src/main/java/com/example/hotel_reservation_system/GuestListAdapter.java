package com.example.hotel_reservation_system;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotel_reservation_system.R;

import java.util.ArrayList;
import java.util.List;

public class GuestListAdapter extends RecyclerView.Adapter<GuestListAdapter.ViewHolder>{

    private List<GuestListData> guestListData;
    private LayoutInflater layoutInflater;
    private RadioGroup checkedRadioGroup = null;

    //Data gets passed in the constructor
    GuestListAdapter(Context context, List<GuestListData> guestListData) {
        this.layoutInflater = LayoutInflater.from(context);
        this.guestListData = guestListData;
    }

    @NonNull
    @Override
    public GuestListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.guest_list_layout, parent, false);
        return new GuestListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestListAdapter.ViewHolder holder, int position) {
        String guestName = guestListData.get(position).getGuestName();
        holder.guestName.setText(guestName);
    }

    @Override
    public int getItemCount() {
        if (guestListData != null) {
            return guestListData.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        EditText guestName;
        RadioGroup radioGroup;
        RadioButton male, female;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.guestName = itemView.findViewById(R.id.guest_name_edit_text);
            this.male = itemView.findViewById(R.id.male_radio_button);
            this.female = itemView.findViewById(R.id.female_radio_button);

            guestName.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    guestListData.get(getAbsoluteAdapterPosition()).setGuestName(guestName.getText().toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            male.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    guestListData.get(getAbsoluteAdapterPosition()).setGender(male.getText().toString());
                }
            });

            female.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    guestListData.get(getAbsoluteAdapterPosition()).setGender(female.getText().toString());
                }
            });
        }
    }
}
