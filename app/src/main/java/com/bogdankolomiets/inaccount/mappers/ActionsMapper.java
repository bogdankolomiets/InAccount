package com.bogdankolomiets.inaccount.mappers;

import com.bogdankolomiets.inaccount.model.Action;
import com.bogdankolomiets.inaccount.model.ActionVO;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * @author bogdan
 * @version 1
 * @date 18.05.17
 */

public class ActionsMapper implements Function<List<Action>, List<ActionVO>> {

    @Override
    public List<ActionVO> apply(List<Action> actions) throws Exception {
        List<ActionVO> result = Observable.fromIterable(actions)
                .map(action -> new ActionVO(action.getType().name(), action.getPriority(), true))
                .toList()
                .blockingGet();
        return result;
    }
}
