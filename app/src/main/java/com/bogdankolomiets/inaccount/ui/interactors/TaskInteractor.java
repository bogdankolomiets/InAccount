package com.bogdankolomiets.inaccount.ui.interactors;

import com.bogdankolomiets.inaccount.model.Action;
import com.bogdankolomiets.inaccount.model.ActionVO;
import com.bogdankolomiets.inaccount.model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * @author bogdan
 * @version 1
 * @date 06.04.17
 */

public class TaskInteractor implements Interactor {

    private final Task mTask;

    @Inject
    public TaskInteractor() {
        mTask = new Task();
    }

    public Observable<List<Action>> getAvailableActions() {
        return Observable.just(getActions());
    }

    private List<Action> getActions() {
        List<Action> result = new ArrayList<>();
        Action subscribe = new Action(Action.Type.SUBSCRIBE);
        subscribe.setPriority(1);
        Action like = new Action(Action.Type.LIKE);
        like.setPriority(2);
        Action comment = new Action(Action.Type.COMMENT);
        comment.setPriority(3);
        Action unsubscribe = new Action(Action.Type.UNSUBSCRIBE);
        unsubscribe.setPriority(4);

        result.add(subscribe);
        result.add(unsubscribe);
        result.add(like);
        result.add(comment);
        Collections.sort(result);
        return result;
    }

    public void saveActions(List<Action> result) {
        Collections.sort(result);
        mTask.setActions(result);
    }

    public void setHasProfilePhoto(boolean hasProfilePhoto) {
        mTask.setHasProfilePhoto(hasProfilePhoto);
    }

    public void subscribersCountChanges(CharSequence sequence) {
        mTask.setSubscribersCount(Integer.valueOf(sequence.toString()));
    }

    public void subscriptionsCountChanged(CharSequence sequence) {
        mTask.setSubscroptionsCount(Integer.valueOf(sequence.toString()));
    }

    public void setHashTagsSearchType(String data) {

    }
}
