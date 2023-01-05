package com.nttdata.spring_t4;

import java.util.Date;

import com.nttdata.spring_t4.utilities.InterfaceUtils;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.LayoutBase;

/**
 * Taller 3 Spring
 * 
 * LogBack Layout
 * 
 * @author Fernando Pérez Nieto
 *
 */
public class NTTDataLayout extends LayoutBase<ILoggingEvent> {

	/** Print prefix */
	private String prefix;
	
	/** Print thread name */
	private boolean printThreadName = Boolean.TRUE;
	
	
	/**
	 * Generate layout
	 * 
	 * @param event
	 * @return String
	 */
	@Override
	public String doLayout(ILoggingEvent event) {
		
		final StringBuilder sb = new StringBuilder();
		sb.append(InterfaceUtils.toStrBuilder((new Date(event.getTimeStamp()).toString()), " ", prefix, " ", event.getLevel().toString()));
		
		if(printThreadName) {
			sb.append(InterfaceUtils.toStrBuilder(" [", event.getThreadName(),"] "));
		}
		
		sb.append((InterfaceUtils.toStrBuilder(" ", event.getLoggerName(), " - ", event.getFormattedMessage(), "\n")));
		
		return sb.toString();
	}

}
