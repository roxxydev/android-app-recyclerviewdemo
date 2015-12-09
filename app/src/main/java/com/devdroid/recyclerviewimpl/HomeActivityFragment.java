package com.devdroid.recyclerviewimpl;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devdroid.recyclerviewimpl.entity.Person;
import com.devdroid.recyclerviewimpl.util.ImageLoaderUtil;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment {

    private View mRootView;
    private RecyclerView mRv;

    public HomeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_home, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRv = (RecyclerView) mRootView.findViewById(R.id.fgmt_home_rv);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        mRv.setLayoutManager(llm);

        List<Person> arrPerson = Person.getPersonsData();
        for (int i=0; i<27; i++) {
            arrPerson.addAll(Person.getPersonsData());
        }

        RVAdapter rvAdapter = new RVAdapter(arrPerson);
        mRv.setAdapter(rvAdapter);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tvItemNo;
        TextView tvName;
        TextView tvAge;
        ImageView ivImg;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.rv_adapter_item_cv);
            tvItemNo = (TextView) itemView.findViewById(R.id.rv_adapter_item_tv_no);
            tvName = (TextView) itemView.findViewById(R.id.rv_adapter_item_tv_name);
            tvAge = (TextView) itemView.findViewById(R.id.rv_adapter_item_tv_age);
            ivImg = (ImageView) itemView.findViewById(R.id.rv_adapter_item_iv);
        }
    }

    public class RVAdapter extends RecyclerView.Adapter<PersonViewHolder>{

        private List<Person> persons;

        RVAdapter(List<Person> persons){
            this.persons = persons;
        }

        @Override
        public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.rv_adapter_item, parent, false);
            PersonViewHolder pvh = new PersonViewHolder(v);
            return pvh;
        }

        @Override
        public void onBindViewHolder(PersonViewHolder holder, int pos) {
            holder.tvItemNo.setText(String.valueOf(pos+1) + ".");
            holder.tvName.setText(persons.get(pos).name);
            holder.tvAge.setText(persons.get(pos).age);
            ImageLoaderUtil.setImage(getActivity(), persons.get(pos).imgUrl,
                    holder.ivImg, R.mipmap.ic_launcher);
        }

        @Override
        public int getItemCount() {
            if (persons != null)
                return persons.size();
            else
                return 0;
        }
    }

}
