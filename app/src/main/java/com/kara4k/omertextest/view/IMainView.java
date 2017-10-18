package com.kara4k.omertextest.view;


import com.kara4k.omertextest.presenter.vo.ReadyPost;

import java.util.List;

public interface IMainView {

    void onShowDialog(String message);

    void onHideDialog();

    void setList(List<ReadyPost> posts);

    void onShowMessage(String message);
}
