package org.rrd4j.graph;

import java.awt.Color;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.rrd4j.ConsolFun;

public class ImageFormatTest {
    private final static String rrdpath = ImageFormatTest.class.getResource("/demo1.rrd").getFile(); 

    private RrdGraphDef doGraph() throws IOException {
        RrdGraphDef gDef = new RrdGraphDef();
        gDef.setWidth(200);
        gDef.setHeight(200);
        gDef.datasource("sun", rrdpath, "sun", ConsolFun.AVERAGE);
        gDef.line("sun", Color.GREEN, "sun temp");
        return gDef;
    }
    
    private void doGraph(RrdGraphDef gDef) throws IOException {
        RrdGraph graph = new RrdGraph(gDef);
        Assert.assertTrue(graph.getRrdGraphInfo().getByteCount() != 0);
    }
    
    @Test
    public void testJPEG() throws IOException {
        RrdGraphDef gDef = doGraph();
        gDef.setImageFormat("jpeg");
        gDef.setImageQuality(0.99f);
        doGraph(gDef);
    }

    @Test
    public void testGIF() throws IOException {
        RrdGraphDef gDef = doGraph();
        gDef.setImageFormat("gif");
        doGraph(gDef);
    }

    @Test
    public void testPNG() throws IOException {
        RrdGraphDef gDef = doGraph();
        gDef.setImageFormat("png");
        doGraph(gDef);
    }

    @Test
    public void testBMP() throws IOException {
        RrdGraphDef gDef = doGraph();
        gDef.setImageFormat("bmp");
        doGraph(gDef);
    }

    @Test(expected=RuntimeException.class)
    public void testWBMP() throws IOException {
        RrdGraphDef gDef = doGraph();
        gDef.setImageFormat("wbmp");
        doGraph(gDef);
    }

}
