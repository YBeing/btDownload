/**
 * className:BtClient
 * author:Lyibing
 * date: 2020/3/20
 */
package com.client;

import com.turn.ttorrent.client.Client;
import com.turn.ttorrent.client.SharedTorrent;
import com.turn.ttorrent.common.Torrent;
import com.turn.ttorrent.tracker.TrackedTorrent;
import com.turn.ttorrent.tracker.Tracker;

import java.io.File;
import java.net.InetAddress;

public class BtClient {
    public static void main(String[] args) throws Exception{
        Tracker tracker = new Tracker(InetAddress.getLocalHost());
        File torrentFile = new File("D:/HC/1917.2019.1080p.SCREENER.DD.2.0.HEVC-DDR[EtHD].torrent");
        TrackedTorrent torrent = new TrackedTorrent(Torrent.load(torrentFile, true));
        tracker.announce(torrent);
        tracker.start();
        //torrentFile = new File("D:/HC");
        File downloadDir = new File("D:/HC");//unsure
        Client client = new Client(InetAddress.getLocalHost(), SharedTorrent.fromFile(torrentFile, downloadDir));
        client.run();

    }
}
