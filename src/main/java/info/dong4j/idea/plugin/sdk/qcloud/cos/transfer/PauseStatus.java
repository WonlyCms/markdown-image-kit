package info.dong4j.idea.plugin.sdk.qcloud.cos.transfer;

/**
 * The status of a pause operation initiated on a {@link Upload}/
 * {@link Download}.
 */
public enum PauseStatus {

    /**
     * transfer successfully paused (and therefore the return information can be
     * used to resume the transfer later on)
     */
    SUCCESS,

    /**
     * pause is not yet applicable since transfer has not started; so no action
     * taken
     */
    NOT_STARTED,

    /**
     * pause is not yet applicable since transfer has not started AND cancel was
     * requested; so we cancel it
     */
    CANCELLED_BEFORE_START,

    /**
     * pause is not possible while transfer is already in progress; so no action
     * taken
     */
    NO_EFFECT,

    /**
     * pause is not possible while transfer is already in progress AND cancel
     * was requested; so we cancel it
     */
    CANCELLED, ;

    /**
     * Returns true if the transfer is paused else false.
     */
    public boolean isPaused() {
        return this == SUCCESS;
    }

    /**
     * Returns true if the transfer is cancelled else false.
     */
    public boolean isCancelled() {
        return this == CANCELLED || this == CANCELLED_BEFORE_START;
    }

    /**
     * Returns true if the transfer is not started or the pause operation has no
     * effect on the transfer.
     */
    public boolean unchanged() {
        return this == NOT_STARTED || this == NO_EFFECT;
    }
}
