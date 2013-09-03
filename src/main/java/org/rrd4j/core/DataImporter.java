package org.rrd4j.core;

import org.rrd4j.ConsolFun;
import org.rrd4j.DsType;

import java.io.IOException;

abstract class DataImporter {

    // header
    abstract String getVersion() throws IOException;

    abstract long getLastUpdateTime() throws IOException;

    abstract long getStep() throws IOException;

    abstract int getDsCount() throws IOException;

    abstract int getArcCount() throws IOException;

    // datasource
    abstract String getDsName(int dsIndex) throws IOException;

    abstract DsType getDsType(int dsIndex) throws IOException;

    abstract long getHeartbeat(int dsIndex) throws IOException;

    abstract double getMinValue(int dsIndex) throws IOException;

    abstract double getMaxValue(int dsIndex) throws IOException;

    // datasource state
    abstract double getLastValue(int dsIndex) throws IOException;

    abstract double getAccumValue(int dsIndex) throws IOException;

    abstract long getNanSeconds(int dsIndex) throws IOException;

    // archive
    abstract ConsolFun getConsolFun(int arcIndex) throws IOException;

    abstract double getXff(int arcIndex) throws IOException;

    abstract int getSteps(int arcIndex) throws IOException;

    abstract int getRows(int arcIndex) throws IOException;

    // archive state
    abstract double getStateAccumValue(int arcIndex, int dsIndex) throws IOException;

    abstract int getStateNanSteps(int arcIndex, int dsIndex) throws IOException;

    abstract double[] getValues(int arcIndex, int dsIndex) throws IOException;

    void release() throws IOException {
        // NOP
    }

}
