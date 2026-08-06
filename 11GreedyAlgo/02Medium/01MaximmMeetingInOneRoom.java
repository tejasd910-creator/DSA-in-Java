import java.util.*;

class Solution {

    static class Meeting {
        int start, end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int maxMeetingsNumber(int[] start, int[] end) {
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

    public ArrayList<Integer> maxMeetingsOrder(int[] s, int[] f) {
        int n = s.length;

        class Meeting {
            int start, finish, idx;
            Meeting(int start, int finish, int idx) {
                this.start = start;
                this.finish = finish;
                this.idx = idx;
            }
        }

        ArrayList<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(s[i], f[i], i + 1));
        }

        Collections.sort(meetings, (a, b) -> {
            if (a.finish != b.finish)
                return a.finish - b.finish;
            return a.idx - b.idx;
        });

        ArrayList<Integer> ans = new ArrayList<>();

        int lastFinish = -1;

        for (Meeting m : meetings) {
            if (m.start > lastFinish) {
                ans.add(m.idx);
                lastFinish = m.finish;
            }
        }

        Collections.sort(ans);
        return ans;
    }
}


// This is the classic question of comparator and greedy.Use comparator to sort final time in ascending then directly use that data to compare and create final list.