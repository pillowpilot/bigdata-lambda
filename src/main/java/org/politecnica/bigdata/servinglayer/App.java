package org.politecnica.bigdata.servinglayer;

import java.io.IOException;

import org.politecnica.bigdata.batchlayer.model.*;

import com.backtype.hadoop.pail.Pail;
import com.backtype.hadoop.pail.Pail.TypedRecordOutputStream;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	DatabaseInitializer initializer = new DatabaseInitializer();
    	initializer.initialize();
    }
}
