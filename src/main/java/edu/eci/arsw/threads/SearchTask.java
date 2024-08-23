package edu.eci.arsw.threads;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SearchTask extends Thread {
    private final int startRange;
    private final int endRange;
    private final String ipAddress;
    private final List<Integer> blacklistOccurrences;
    private static final int ALARM_THRESHOLD = 5;
    private int checkedCount;

    public SearchTask(int startRange, int endRange, String ipAddress) {
        this.startRange = startRange;
        this.endRange = endRange;
        this.ipAddress = ipAddress;
        this.blacklistOccurrences = new LinkedList<>();
    }

    @Override
    public void run() {
        int occurrenceCounter = 0;
        HostBlacklistsDataSourceFacade blacklistDataSource = HostBlacklistsDataSourceFacade.getInstance();
        checkedCount = 0;

        for (int i = startRange; i <= endRange && occurrenceCounter < ALARM_THRESHOLD; i++) {
            checkedCount++;
            if (blacklistDataSource.isInBlackListServer(i, ipAddress)) {
                blacklistOccurrences.add(i);
                occurrenceCounter++;
            }
        }
    }

    public List<Integer> getBlacklistOccurrences() {
        return blacklistOccurrences;
    }

    public int getCheckedCount() {
        return checkedCount;
    }
}
