package com.deepz.string.week4;

import java.util.HashSet;
import java.util.Set;

/**
 * created by zhangdingping at 2019/12/4
 * <p>
 * 独特的电子邮件  929
 * <p>
 * 每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
 * <p>
 * 例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
 * <p>
 * 除了小写字母，这些电子邮件还可能包含 '.' 或 '+'。
 * <p>
 * 如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
 * <p>
 * 如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
 * <p>
 * 可以同时使用这两个规则。
 * <p>
 * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
 */
public class UniqueEmailAddress {

    public int numUniqueEmails(String[] emails) {

        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            StringBuilder localNameBuilder = new StringBuilder();
            int at = email.lastIndexOf('@');
            String localName = email.substring(0, at);

            for (int i = 0; i < localName.length(); i++) {
                char c = localName.charAt(i);
                if (c == '+') break;
                if (c != '.') localNameBuilder.append(c);
            }
            String uniqueEmail = localNameBuilder.append("@").append(email.substring(at + 1)).toString();
            uniqueEmails.add(uniqueEmail);
        }

        return uniqueEmails.size();
    }
}
