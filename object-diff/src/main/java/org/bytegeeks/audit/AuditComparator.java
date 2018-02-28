package org.bytegeeks.audit;

import java.util.EnumSet;
import java.util.List;

import org.bytegeeks.audit.ObjectDiff.ObjectDiffFlags;

public interface AuditComparator {
  
  public List<ObjectDiff> diff(Object left, Object right);
  
  public List<ObjectDiff> diff(Object left, Object right, EnumSet<ObjectDiffFlags> flags);
  
}
