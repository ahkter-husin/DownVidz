package com.ui.downvid.database.playlist.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.ui.downvid.database.BasicDAO;
import com.ui.downvid.database.playlist.model.PlaylistEntity;

import java.util.List;

import io.reactivex.Flowable;

import static com.ui.downvid.database.playlist.model.PlaylistEntity.PLAYLIST_ID;
import static com.ui.downvid.database.playlist.model.PlaylistEntity.PLAYLIST_NAME;
import static com.ui.downvid.database.playlist.model.PlaylistEntity.PLAYLIST_TABLE;

@Dao
public abstract class PlaylistDAO implements BasicDAO<PlaylistEntity> {
    @Override
    @Query("SELECT * FROM " + PLAYLIST_TABLE)
    public abstract Flowable<List<PlaylistEntity>> getAll();

    @Override
    @Query("DELETE FROM " + PLAYLIST_TABLE)
    public abstract int deleteAll();

    @Override
    public Flowable<List<PlaylistEntity>> listByService(int serviceId) {
        throw new UnsupportedOperationException();
    }

    @Query("SELECT * FROM " + PLAYLIST_TABLE + " WHERE " + PLAYLIST_ID + " = :playlistId")
    public abstract Flowable<List<PlaylistEntity>> getPlaylist(final long playlistId);

    @Query("DELETE FROM " + PLAYLIST_TABLE + " WHERE " + PLAYLIST_ID + " = :playlistId")
    public abstract int deletePlaylist(final long playlistId);
}
