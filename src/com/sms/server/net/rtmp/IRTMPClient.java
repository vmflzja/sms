package com.sms.server.net.rtmp;

import java.util.Map;

import com.sms.server.api.event.IEventDispatcher;
import com.sms.server.api.service.IPendingServiceCallback;
import com.sms.server.messaging.IMessage;

public interface IRTMPClient {

	public void setConnectionClosedHandler(Runnable connectionClosedHandler);
	public void setExceptionHandler(ClientExceptionHandler exceptionHandler);
	public void setStreamEventDispatcher(IEventDispatcher streamEventDispatcher);
	public void setServiceProvider(Object serviceProvider);
	
	public void connect(String server, int port, String application);
	public void connect(String server, int port, String application, IPendingServiceCallback connectCallback);
	public void connect(String server, int port, Map<String, Object> connectionParams);
	public void connect(String server, int port, Map<String, Object> connectionParams, IPendingServiceCallback connectCallback);
	public void connect(String server, int port, Map<String, Object> connectionParams, IPendingServiceCallback connectCallback, Object[] connectCallArguments);
	
	public void invoke(String method, IPendingServiceCallback callback);
	public void invoke(String method, Object[] params, IPendingServiceCallback callback);
	public void disconnect();
	public void createStream(IPendingServiceCallback callback);
	public void publish(int streamId, String name, String mode, INetStreamEventHandler handler);
	public void unpublish(int streamId);
	public void publishStreamData(int streamId, IMessage message);
	public void play(int streamId, String name, int start, int length);
	public void play2(int streamId, Map<String, ?> playOptions);
	
	//public IClientSharedObject getSharedObject(String name, boolean persistent);
	public Map<String, Object> makeDefaultConnectionParams(String server, int port, String application);
}
