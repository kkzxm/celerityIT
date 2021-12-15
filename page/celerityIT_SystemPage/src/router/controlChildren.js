export default [
    {
        path: "/",
        redirect: "/index"
    },
    {
        path: "/index",
        name: "index",
        component: () => import("@/views/users/Index")
    },
    {
        path: "/word",
        name: "word",
        component: () => import("@/views/show/data/data-word"),
    },
    {
        path: "/chinese",
        name: "chinese",
        component: () => import("@/views/show/data/data-chinese"),
    },
    {
        path: "/wordToChinese",
        name: "wordToChinese",
        component: () => import("@/views/show/data/data-wordToChinese"),
    },
    {
        path: "/wordType",
        name: "wordType",
        component: () => import("@/views/show/data/data-wordType"),
    },
    {
        path: "/wordTOType",
        name: "wordToType",
        component: () => import("@/views/show/data/data-wordToType"),
    },
    {
        path: "/wordTag",
        name: "wordTag",
        component: () => import("@/views/show/data/data-wordTag"),
    },
    {
        path: "/wordToTag",
        name: "wordToTag",
        component: () => import("@/views/show/data/data-wordToTag"),
    },
    {
        path: "/wordTagGroup",
        name: "wordTagGroup",
        component: () => import("@/views/show/data/data-tagGroup"),
    }
]


