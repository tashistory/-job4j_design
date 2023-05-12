package ru.job4j.generic;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenRoleNameIsViewers() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Viewers"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Viewers");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Editors"));
        Role result = store.findById("2");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRoleNameIsCreators() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Creators"));
        store.add(new Role("1", "Editors"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Creators");
    }

    @Test
    void whenReplaceThenRoleNameIsViewers() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Editors"));
        store.replace("1", new Role("1", "Viewers"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Viewers");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Editors"));
        store.replace("3", new Role("3", "Viewers"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Editors");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Editors"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenUsernameIsEditors() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Editors"));
        store.delete("4");
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Editors");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Editors"));
        boolean rsl = store.replace("1", new Role("1", "Viewers"));
        assertThat(rsl).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Viewers"));
        boolean rsl = store.replace("5", new Role("5", "Editors"));
        assertThat(rsl).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        UserStore store = new UserStore();
        store.add(new User("3", "Editors"));
        boolean rsl = store.delete("3");
        assertThat(rsl).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        UserStore store = new UserStore();
        store.add(new User("4", "Editors"));
        boolean rsl = store.delete("1");
        assertThat(rsl).isFalse();
    }
}