package com.mrdiaz.apigoogleplacesproject;

import java.util.List;

/**
 * Created by mrdiaz on 19/02/2018.
 */

class PrediccionResult {

    private List<Prediction> predictions;
    private String status;

    public PrediccionResult() {
    }

    public List<Prediction> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<Prediction> predictions) {
        this.predictions = predictions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrediccionResult that = (PrediccionResult) o;

        if (predictions != null ? !predictions.equals(that.predictions) : that.predictions != null)
            return false;
        return status != null ? status.equals(that.status) : that.status == null;
    }

    @Override
    public int hashCode() {
        int result = predictions != null ? predictions.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
