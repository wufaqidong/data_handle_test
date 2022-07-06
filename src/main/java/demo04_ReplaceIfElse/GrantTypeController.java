package demo04_ReplaceIfElse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: a-rookie-is-a-god
 * @description:
 * @author: xiebinbin
 * @create: 2022-07-06 19:06
 **/

public class GrantTypeController {
    @Autowired
    private QueryGrantTypeService queryGrantTypeService;

    public static void main(String resourceName) {
        return queryGrantTypeService.getResult(resourceName);
    }
}
