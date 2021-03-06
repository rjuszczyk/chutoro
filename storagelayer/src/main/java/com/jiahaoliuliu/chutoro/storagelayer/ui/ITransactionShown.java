package com.jiahaoliuliu.chutoro.storagelayer.ui;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * TODO: This interface should be extended from {@link com.jiahaoliuliu.chutoro.entity.ITransaction}
 * and IDestination (to be created) and IDestinationGroup (to be created)
 */
public interface ITransactionShown {

    @NotNull
    int getQuantity();

    @NotNull
    String getCurrency();

    @NotNull
    String getSource();

    @NotNull
    String getDestinationCodeName();

    @NotNull
    long getDate();

    @NotNull
    String getDestinationName();

    boolean hasDestinationName();

    @Nullable
    long getDestinationLatitude();

    @Nullable
    long getDestinationLongitude();

    @Nullable
    String getDestinationDescription();

    @NotNull
    String getDestinationGroupName();

    boolean hasDestinationGroupName();

    @NotNull
    String getDestinationGroupCategory();

    boolean hasDestinationGroupCategory();

    @Nullable
    long getDestinationGroupLatitude();

    @Nullable
    long getDestinationGroupLongitude();

    @Nullable
    String getDestinationGroupDescription();
}
