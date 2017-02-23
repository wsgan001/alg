/**
 * 
 */
package alg.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ScheduleRequest {
	public ScheduleRequest(String id, String location, Integer start, Integer end) {
		this.id = id;
		this.location = location;
		this.startTime = start;
		this.endTime = end;
	}
	public String id;
	public String location;
	public Integer startTime;
	public Integer endTime;
}

public class Schedule {
	public Schedule (List <ScheduleRequest> requests) {
		Map <String, List <ScheduleRequest>> map = new HashMap <> ();
		for (ScheduleRequest r: requests)
		{
			String loc = r.location;
			if (map.get(loc) == null)
			{
				map.put(loc, new ArrayList <ScheduleRequest> ());
			}
			map.get(loc).add(r);
		}
		
	}
}
