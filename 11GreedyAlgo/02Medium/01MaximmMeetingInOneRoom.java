import java.util.*;

class Solution {

    static class Meeting {
        int start, end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;

        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }

        // Sort by ending time
        Collections.sort(meetings, (a, b) -> a.end - b.end);

        int count = 1;
        int lastEnd = meetings.get(0).end;

        for (int i = 1; i < n; i++) {
            if (meetings.get(i).start > lastEnd) {
                count++;
                lastEnd = meetings.get(i).end;
            }
        }

        return count;
    }
}
