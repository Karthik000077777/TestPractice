package com.earthquake;

import java.util.List;

public class AllObjects {
	
	private List<Features> features;

    private Metadata metadata;

    private String[] bbox;

    private String type;
    
    
    public List<Features> getFeatures() {
		return features;
	}

	public void setFeatures(List<Features> features) {
		this.features = features;
	}

	public Metadata getMetadata ()
    {
        return metadata;
    }

    public void setMetadata (Metadata metadata)
    {
        this.metadata = metadata;
    }

    public String[] getBbox ()
    {
        return bbox;
    }

    public void setBbox (String[] bbox)
    {
        this.bbox = bbox;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }
}
