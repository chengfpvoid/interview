package org.itstack.interview.sms;

public final class SmsInfo {

    private final Long id;

    private final String url;

    private final Long maxSizeInBytes;

    public SmsInfo(Long id, String url, Long maxSizeInBytes) {
        this.id = id;
        this.url = url;
        this.maxSizeInBytes = maxSizeInBytes;
    }

    public SmsInfo(SmsInfo smsInfo) {
        this.id = smsInfo.getId();
        this.url = smsInfo.getUrl();
        this.maxSizeInBytes = smsInfo.getMaxSizeInBytes();
    }


    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Long getMaxSizeInBytes() {
        return maxSizeInBytes;
    }
}
