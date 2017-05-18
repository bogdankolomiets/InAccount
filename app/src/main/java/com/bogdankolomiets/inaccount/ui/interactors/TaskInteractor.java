package com.bogdankolomiets.inaccount.ui.interactors;

import com.bogdankolomiets.inaccount.model.Action;

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

    private List<Action> mAvailableActions;

    @Inject
    public TaskInteractor() {

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
}
