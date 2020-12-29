package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gzm
 * @date 2020/12/25 3:11 下午
 * @desc: 341. 扁平化嵌套列表迭代器
 * <p>
 * 使用懒迭代的方式
 */
public class No_341_Flattening_nested_list_iterators {
    @Test
    public void test() {
        List<NestedInteger> lists = new ArrayList<>();
//        lists.add(new NestedInteger() {
//            @Override
//            public boolean isInteger() {
//                return false;
//            }
//
//            @Override
//            public Integer getInteger() {
//                return null;
//            }
//
//            @Override
//            public List<NestedInteger> getList() {
//                List<NestedInteger> lists = new ArrayList<>();
//                lists.add(new NestedInteger() {
//                    @Override
//                    public boolean isInteger() {
//                        return true;
//                    }
//
//                    @Override
//                    public Integer getInteger() {
//                        return 1;
//                    }
//
//                    @Override
//                    public List<NestedInteger> getList() {
//                        return null;
//                    }
//                });
//                lists.add(new NestedInteger() {
//                    @Override
//                    public boolean isInteger() {
//                        return true;
//                    }
//
//                    @Override
//                    public Integer getInteger() {
//                        return 1;
//                    }
//
//                    @Override
//                    public List<NestedInteger> getList() {
//                        return null;
//                    }
//                });
//                return lists;
//            }
//        });
//
//        lists.add(new NestedInteger() {
//            @Override
//            public boolean isInteger() {
//                return true;
//            }
//
//            @Override
//            public Integer getInteger() {
//                return 2;
//            }
//
//            @Override
//            public List<NestedInteger> getList() {
//                return null;
//            }
//        });
//
//        lists.add(new NestedInteger() {
//            @Override
//            public boolean isInteger() {
//                return false;
//            }
//
//            @Override
//            public Integer getInteger() {
//                return null;
//            }
//
//            @Override
//            public List<NestedInteger> getList() {
//                List<NestedInteger> lists = new ArrayList<>();
//                lists.add(new NestedInteger() {
//                    @Override
//                    public boolean isInteger() {
//                        return true;
//                    }
//
//                    @Override
//                    public Integer getInteger() {
//                        return 1;
//                    }
//
//                    @Override
//                    public List<NestedInteger> getList() {
//                        return null;
//                    }
//                });
//                lists.add(new NestedInteger() {
//                    @Override
//                    public boolean isInteger() {
//                        return true;
//                    }
//
//                    @Override
//                    public Integer getInteger() {
//                        return 1;
//                    }
//
//                    @Override
//                    public List<NestedInteger> getList() {
//                        return null;
//                    }
//                });
//                return lists;
//            }
//        });


//        lists.add(new NestedInteger() {
//            @Override
//            public boolean isInteger() {
//                return true;
//            }
//
//            @Override
//            public Integer getInteger() {
//                return 1;
//            }
//
//            @Override
//            public List<NestedInteger> getList() {
//                return null;
//            }
//        });
//
//        lists.add(new NestedInteger() {
//            @Override
//            public boolean isInteger() {
//                return false;
//            }
//
//            @Override
//            public Integer getInteger() {
//                return null;
//            }
//
//            @Override
//            public List<NestedInteger> getList() {
//                List<NestedInteger> lists = new ArrayList<>();
//                lists.add(new NestedInteger() {
//                    @Override
//                    public boolean isInteger() {
//                        return true;
//                    }
//
//                    @Override
//                    public Integer getInteger() {
//                        return 2;
//                    }
//
//                    @Override
//                    public List<NestedInteger> getList() {
//                        return null;
//                    }
//                });
//
//                lists.add(new NestedInteger() {
//                    @Override
//                    public boolean isInteger() {
//                        return false;
//                    }
//
//                    @Override
//                    public Integer getInteger() {
//                        return null;
//                    }
//
//                    @Override
//                    public List<NestedInteger> getList() {
//                        List<NestedInteger> lists = new ArrayList<>();
//                        lists.add(new NestedInteger() {
//                            @Override
//                            public boolean isInteger() {
//                                return true;
//                            }
//
//                            @Override
//                            public Integer getInteger() {
//                                return 3;
//                            }
//
//                            @Override
//                            public List<NestedInteger> getList() {
//                                return null;
//                            }
//                        });
//
//                        return lists;
//                    }
//                });
//
//                return lists;
//            }
//        });

        lists.add(new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public List<NestedInteger> getList() {
                List<NestedInteger> lists = new ArrayList<>();
                lists.add(new NestedInteger() {
                    @Override
                    public boolean isInteger() {
                        return true;
                    }

                    @Override
                    public Integer getInteger() {
                        return 1;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                });

                return lists;
            }
        });

        lists.add(new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public List<NestedInteger> getList() {
                return new ArrayList<>();
            }
        });

        NestedIterator nestedIterator = new NestedIterator(lists);
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }
    }

    class NestedIterator implements Iterator<Integer> {

        private LinkedList<NestedInteger> list;

        public NestedIterator(List<NestedInteger> nestedList) {
            // 不直接用 nestedList 的引用，是因为不能确定它的底层实现
            // 必须保证是 LinkedList，否则下面的 addFirst 会很低效
            list = new LinkedList<>(nestedList);
        }

        @Override
        public Integer next() {
            // hasNext 方法保证了第一个元素一定是整数类型
            return list.remove(0).getInteger();
        }

        @Override
        public boolean hasNext() {
            // 循环拆分列表元素，直到列表第一个元素是整数类型
            while (!list.isEmpty() && !list.get(0).isInteger()) {
                // 当列表开头第一个元素是列表类型时，进入循环
                List<NestedInteger> first = list.remove(0).getList();
                // 将第一个列表打平并按顺序添加到开头
                for (int i = first.size() - 1; i >= 0; i--) {
                    list.addFirst(first.get(i));
                }
            }
            return !list.isEmpty();
        }
    }

    interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }
}

