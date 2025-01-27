package com.github.featzhang.demo.pekko;

import org.apache.pekko.actor.ActorRef;
import org.apache.pekko.actor.ActorSystem;
import org.apache.pekko.actor.Props;

public class DemoEntry {
  public static void main(String[] args) {
    ActorSystem actorSystem = ActorSystem.create("think-in-flink");
    // 消息接收者
    ActorRef pekkoRpcRef = actorSystem.actorOf(Props.create(PekkoRpcReceiveActor.class), "PekkpoReceive");
    // 消息发送者
    ActorRef pekkoRpcSenderRef = actorSystem.actorOf(Props.create(PekkoRpcSenderActor.class), "PekkoRpcSenderActor");
    // 发送消息
    pekkoRpcRef.tell(new PekkoData("hello world!"), pekkoRpcSenderRef);
  }
}
