package com.mrdiaz.apigoogleplacesproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by mrdiaz on 20/02/2018.
 */

public class CityAutoCompleteAdapter extends BaseAdapter implements Filterable {

    private Context mContext;
    TextView autoCompleteTextView;
    private List<Prediction> resultList = new ArrayList<Prediction>();


    public CityAutoCompleteAdapter (Context context){
        mContext = context;
    }

    //Esto es de la extensión de BaseAdapter
    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public Prediction getItem(int i) {
        return resultList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        //android.R.layout.simple_dropdown_item_1line
        //return null;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false);

        }

        //Obtenemos la referencia al textView
        autoCompleteTextView = convertView.findViewById(android.R.id.text1);
        //Obtenemos el elemento i-esimo
        Prediction p = getItem(i);
        //Seteamos el texto
        autoCompleteTextView.setText(p.getDescription());


        return  convertView;
    }




    //Es de la implementacion de filterable
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                //return null;
                FilterResults filterResults = new FilterResults();
                if (constraint != null){
                    //Realizar la busqueda
                        List<Prediction> resultados = findCities(constraint);
                        //Si tenemos el resultado lo lanzamos
                        if(resultados != null){
                            filterResults.values = resultados;
                            filterResults.count = resultados.size();
                        }
                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    resultList = (List<Prediction>) results.values;
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
    }

    private List<Prediction> findCities(CharSequence text){
        List<Prediction> result = null;

        //Generar el servicio
        GooglePlacesApi api =  ServiceGenerator.createService(GooglePlacesApi.class);

        //Obtener la peticion
        Call<PrediccionResult> call = api.autoComplete(String.valueOf(text));

        try {
            Response<PrediccionResult> response = call.execute();

            if(response.isSuccessful()){
                if("OK".equalsIgnoreCase(response.body().getStatus()))
                result = response.body().getPredictions();
            }

            //TODO Manejo de errores

        } catch (IOException e) {
            //TODO Manejo de la exepcion
            e.printStackTrace();
        }


        return result;
    }

}
