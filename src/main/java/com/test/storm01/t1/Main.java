package com.test.storm01.t1;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;

public class Main {

    public static void main(String[] args) throws Exception{
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("tuple-input", new SimpleSpout());
        builder.setBolt("simpleBolt", new SimpleBolt()).shuffleGrouping("tuple-input");
        Config conf = new Config();
        conf.setDebug(true);
        conf.put(Config.TOPOLOGY_MAX_SPOUT_PENDING, 1);
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("simpleExample01", conf, builder.createTopology());
        Thread.sleep(100000);
        

    }

}
