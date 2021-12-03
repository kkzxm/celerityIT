package com.lingDream.celerityIT.entity.dataBase;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Table extends TableOrView {

}
