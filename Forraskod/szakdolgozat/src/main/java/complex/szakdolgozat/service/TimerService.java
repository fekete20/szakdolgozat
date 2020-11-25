package complex.szakdolgozat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class TimerService {
	private long start;
	private long finish;
	private List<Long> elapsedTimeList = new ArrayList<>();

	public long getStart() {
		return start;
	}

	public long getFinish() {
		return finish;
	}

	public void setStart() {
		start = System.currentTimeMillis();
	}

	public void setFinish() {
		finish = System.currentTimeMillis();
		elapsedTimeList.add((finish - getStart()) / 1000);
	}

	public Long getElapsedTime() {
		long elapsedTime = 0;

		for (long time : elapsedTimeList) {
			elapsedTime += time;
		}
		return elapsedTime;
	}

	public void stop() {
		elapsedTimeList.clear();
	}
}
