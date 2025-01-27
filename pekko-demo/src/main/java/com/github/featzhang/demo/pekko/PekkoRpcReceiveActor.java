package com.github.featzhang.demo.pekko;

import org.apache.pekko.actor.AbstractActor;
import org.apache.pekko.actor.ActorRef;
import org.apache.pekko.japi.pf.ReceiveBuilder;

public class PekkoRpcReceiveActor extends AbstractActor {

  @Override
  public Receive createReceive() {
    return ReceiveBuilder.create()
        .match(PekkoData.class, this::handleMessage)
        .build();
  }

  public void handleMessage(final PekkoData message) {
    // 获取消息的发送者
    ActorRef sender = getSender();
    // 获取资深的ref
    ActorRef self = getSelf();
    System.out.println(String.format("sender(%s) receive message: %s", sender.toString(), message.getContent()));
    // Actor 作为通信的主体, 可以改变自身的状态，可以接受消息，也可以发送消息，还可以创建新的Actor
    sender.tell(new PekkoData("[PekkoRpcActor] received"), self);
  }

}
