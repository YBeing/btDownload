/**
 * className:TrackerListen
 * author:Lyibing
 * date: 2020/3/20
 */
package com.tracker;

import com.turn.ttorrent.tracker.TrackedTorrent;
import com.turn.ttorrent.tracker.Tracker;

import java.io.File;
import java.io.FilenameFilter;
import java.net.InetAddress;

public class TrackerListen {
    public static void main(String[] args) {
        try {
            Tracker tracker=new Tracker(InetAddress.getLocalHost());
            FilenameFilter filenameFilter=new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.endsWith(".torrent");
                }
            };
            for (File f : new File("/path/to/torrent/files").listFiles(filenameFilter)) {
                tracker.announce(TrackedTorrent.load(f));
            }
            tracker.start();
            tracker.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
